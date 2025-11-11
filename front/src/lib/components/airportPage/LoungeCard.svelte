<script>
    import WifiHigh from "phosphor-svelte/lib/WifiHigh";

    let {lounge} = $props();
</script>

<div class="card card-side bg-base-100 shadow-sm max-h-40 border-base-200 border-1">
    <figure>
        <img
                src="https://oss-images.dragonpass.com.cn/uploadFile/trafficsiteImg/20250611/dcc15c56-7c77-49c1-83a1-1b4293416647.jpg"
                class="w-52"
                alt="Movie"
        />
    </figure>
    <div class="badge badge-sm absolute top-2 left-30 z-10">
        Terminal 2
    </div>
    <div class="card-body gap-6">
        <div>
            <h2 class="card-title font-medium">British Airways Lounge</h2>
            <p class="text-secondary">Airside - After passport control and security check, take the nearest elevator to level 4, follow directions to gate A18 and then take the lift to Level 2.</p>
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
            <h2 class="text-2xl text-primary">45€</h2>
            <button class="btn btn-primary">Reserve Now</button>
        </div>
    </div>
</div>