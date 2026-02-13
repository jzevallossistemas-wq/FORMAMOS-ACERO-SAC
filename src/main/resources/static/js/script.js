// Custom JavaScript for FORMAMOS ACERO SAC

// Initialize tooltips
document.addEventListener('DOMContentLoaded', function() {
    var tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'));
    var tooltipList = tooltipTriggerList.map(function (tooltipTriggerEl) {
        return new bootstrap.Tooltip(tooltipTriggerEl);
    });
});

// Auto-hide alerts after 5 seconds
document.addEventListener('DOMContentLoaded', function() {
    var alerts = document.querySelectorAll('.alert-dismissible');
    alerts.forEach(function(alert) {
        setTimeout(function() {
            var bsAlert = new bootstrap.Alert(alert);
            bsAlert.close();
        }, 5000);
    });
});

// Form validation
(function () {
    'use strict'
    var forms = document.querySelectorAll('.needs-validation');
    Array.prototype.slice.call(forms).forEach(function (form) {
        form.addEventListener('submit', function (event) {
            if (!form.checkValidity()) {
                event.preventDefault();
                event.stopPropagation();
            }
            form.classList.add('was-validated');
        }, false);
    });
})();

// Confirm delete actions
function confirmDelete(message) {
    return confirm(message || '¿Está seguro de eliminar este registro?');
}

// Format currency
function formatCurrency(amount, currency = 'PEN') {
    const formatter = new Intl.NumberFormat('es-PE', {
        style: 'currency',
        currency: currency
    });
    return formatter.format(amount);
}

// Format date
function formatDate(date) {
    const d = new Date(date);
    const day = String(d.getDate()).padStart(2, '0');
    const month = String(d.getMonth() + 1).padStart(2, '0');
    const year = d.getFullYear();
    return `${day}/${month}/${year}`;
}

// Show loading spinner
function showLoading(element) {
    element.innerHTML = '<span class="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span> Cargando...';
    element.disabled = true;
}

// Hide loading spinner
function hideLoading(element, originalText) {
    element.innerHTML = originalText;
    element.disabled = false;
}

// Search debounce function
function debounce(func, wait) {
    let timeout;
    return function executedFunction(...args) {
        const later = () => {
            clearTimeout(timeout);
            func(...args);
        };
        clearTimeout(timeout);
        timeout = setTimeout(later, wait);
    };
}

// Print page
function printPage() {
    window.print();
}

// Export to PDF (placeholder - implement with backend)
function exportToPDF() {
    alert('Función de exportación a PDF en desarrollo');
}

// Export to Excel (placeholder - implement with backend)
function exportToExcel() {
    alert('Función de exportación a Excel en desarrollo');
}
