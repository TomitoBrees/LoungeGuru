<script>
    let {icon, label, value} = $props();
</script>

<div class="bg-base-100 w-48 py-4 px-4 rounded-md shadow-xl flex flex-col gap-1 items-center">
    <span class="flex gap-2 items-center text-secondary">
        {@render icon()}
        {label}
    </span>
    <span class="text-2xl">
        {@render value()}
    </span>
</div>