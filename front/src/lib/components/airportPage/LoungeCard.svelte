<script>
    import WifiHigh from "phosphor-svelte/lib/WifiHigh";

    let {lounge} = $props();
    console.log("lounge numero", lounge)
</script>

{#if lounge}
<div class="card card-side bg-base-100 shadow-sm max-h-40 border-base-200 border-1">
    <figure>
        <img
                src={lounge.imageUrl}
                class="w-52"
                alt="Movie"
        />
    </figure>
    <div class="badge badge-sm absolute top-2 left-30 z-10">
        {lounge.terminal}
    </div>
    <div class="card-body gap-6 max-w-3/4">
        <div>
            <h2 class="card-title font-medium">{lounge.name}</h2>
            <p class="text-secondary">{lounge.location}</p>
        </div>

        <div class="flex gap-5">
            <div class="badge badge-ghost">
                <WifiHigh />
                Wifi
            </div>
            <div class="badge badge-ghost">
                <WifiHigh />
                Wifi
            </div>
            <div class="badge badge-ghost">
                <WifiHigh />
                Wifi
            </div>
            <div class="badge badge-ghost">
                <WifiHigh />
                Wifi
            </div>
            <div class="badge badge-ghost">
                <WifiHigh />
                Wifi
            </div>
        </div>
        <div class="flex flex-col absolute bottom-5 right-5 items-center gap-5">
            <h2 class="text-2xl text-primary">{lounge.price}€</h2>
            <button class="btn btn-primary">Reserve Now</button>
        </div>
    </div>
</div>
{/if}