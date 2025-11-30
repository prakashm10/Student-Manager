// Small progressive enhancements: debounced search and nicer delete confirmation modal
document.addEventListener('DOMContentLoaded', function () {
  // Debounce helper
  function debounce(fn, wait) {
    let t;
    return function () {
      const args = arguments;
      clearTimeout(t);
      t = setTimeout(() => fn.apply(this, args), wait);
    };
  }

  // Client-side debounce search: submit form after user pauses typing
  const searchInput = document.querySelector('input[name="search"]');
  if (searchInput) {
    const form = searchInput.closest('form');
    searchInput.addEventListener('input', debounce(function () {
      if (form) form.submit();
    }, 350));
  }

  // Enhanced delete: replace default confirm() with Bootstrap modal
  const deleteLinks = document.querySelectorAll('a[data-delete-url]');
  if (deleteLinks.length) {
    // create modal markup once
    const modalHtml = `
      <div class="modal fade" id="confirmDeleteModal" tabindex="-1" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title">Confirm delete</h5>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">Are you sure you want to delete this student? This can't be undone.</div>
            <div class="modal-footer">
              <button type="button" class="btn btn-outline-secondary" data-bs-dismiss="modal">Cancel</button>
              <a href="#" id="confirmDeleteBtn" class="btn btn-danger">Delete</a>
            </div>
          </div>
        </div>
      </div>`;

    document.body.insertAdjacentHTML('beforeend', modalHtml);
    const confirmModalEl = document.getElementById('confirmDeleteModal');
    const confirmDeleteBtn = document.getElementById('confirmDeleteBtn');
    let bsModal = null;
    if (confirmModalEl) {
      bsModal = new bootstrap.Modal(confirmModalEl);
    }

    deleteLinks.forEach(link => {
      link.addEventListener('click', function (ev) {
        ev.preventDefault();
        const url = link.dataset.deleteUrl || link.href;
        confirmDeleteBtn.setAttribute('href', url);
        if (bsModal) bsModal.show();
      });
    });
  }
});
