document.addEventListener("DOMContentLoaded", function () {

    document.querySelectorAll("[data-currency]").forEach(display => {
        const hiddenId = display.dataset.currency;
        const hidden = document.getElementById(hiddenId);

        if (!hidden) return;

        // Load giá trị ban đầu (edit form)
        if (hidden.value) {
            display.value = Number(hidden.value).toLocaleString("vi-VN");
        }

        display.addEventListener("input", function () {
            let raw = this.value.replace(/\D/g, "");

            if (raw === "") {
                hidden.value = "";
                this.value = "";
                return;
            }

            hidden.value = raw;
            this.value = Number(raw).toLocaleString("vi-VN");
        });
    });

});
