<script>
    import CalendarBlank from "phosphor-svelte/lib/CalendarBlank";

    let myDatepicker;

    import { browser } from "$app/environment";
    import { onMount } from "svelte";

    onMount(async () => {
        if (!browser) return;

        const Pikaday = (await import("pikaday")).default;

        const picker = new Pikaday({
            field: myDatepicker,
            format: "YYYY-MM-DD",
        });

        return () => picker.destroy();
    });
</script>

<div class="relative w-64">
    <CalendarBlank
            class="absolute left-3 top-1/2 -translate-y-1/2 size-5 z-10 pointer-events-none"
    />

    <input type="text"
           class="input pika-single w-64 h-12 px-12 py-2 border-2 border-primary rounded-md text-center text-base placeholder:text-center placeholder:text-base-content focus:outline-none focus:ring-2 focus:ring-primary transition"
           bind:this={myDatepicker} value="Pick a day"/>
</div>