<script>
    export let title;
    export let spanCols = 1;
    export let spanRows = 1;

    const colSpanClass = {
        1: "col-span-1",
        2: "col-span-2",
        3: "col-span-3",
        4: "col-span-4",
    }[spanCols] || "col-span-1";

    const rowSpanClass = {
        1: "row-span-1",
        2: "row-span-2",
        3: "row-span-3",
    }[spanRows] || "row-span-1";
</script>

<div class={`card bg-base-100 card-border rounded-md border-b-base-300 card-sm ${colSpanClass} ${rowSpanClass}`}>
    <figure class="h-full p-1">
        <img
                src="https://img.daisyui.com/images/stock/photo-1606107557195-0e29a4b5b4aa.webp"
                alt="Shoes"
                class="w-full h-full object-cover"
        />
    </figure>
    <div class="card-body py-2 px-4 h-16">
        <div class="flex justify-between items-center">
            <div class="flex items-center {spanCols > 2 ? 'gap-2' : 'flex-col'}">
                <h4 class="font-light text-lg">{title}</h4>
                <div class="badge badge-xs badge-accent">Skytrax #1</div>
            </div>
            <div>
                <p class="text-base font-extralight">From 22€</p>
            </div>
        </div>
    </div>
</div>