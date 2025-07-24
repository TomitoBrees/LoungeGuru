<script>
    import User from "phosphor-svelte/lib/user";
    import SignOut from "phosphor-svelte/lib/SignOut";
    let { user } = $props();

    function getInitials() {
        return user.firstName.charAt(0) + user.lastName.charAt(0);
    }
</script>

<nav class="flex justify-between items-center mx-24 mb-32">
    <div class="flex gap-4 items-center justify-center">
        <img src="logo.png" alt="logo of the website" width="61" height="61"/>
        <h1 class="text-4xl font-semibold">LoungeGuru</h1>
    </div>
    <div>
        <button class="btn btn-lg btn-ghost">Reservations</button>

        {#if user}
            <div class="dropdown dropdown-end">
                <div tabindex="0" role="button"  class="avatar avatar-placeholder">
                    <div class="bg-accent text-neutral-content w-10 rounded-full">
                        <span class="text-md">{getInitials()}</span>
                    </div>
                </div>
                <ul tabindex="0" class="dropdown-content menu bg-base-100 rounded-box z-1 w-52 p-2 mt-2 shadow-md border border-base-200">
                    <li>
                        <a class="group text-accent hover:bg-accent hover:text-accent-content">
                            <User class="text-accent group-hover:text-accent-content"/>
                            Profile
                        </a>
                    </li>
                    <li>
                        <a class="group text-error hover:bg-error hover:text-error-content">
                            <SignOut class="text-error group-hover:text-error-content" />
                            Logout
                        </a>
                    </li>
                </ul>
            </div>
        {:else}
            <a href="/login">
                <button class="btn btn-lg btn-primary">Login</button>
            </a>
        {/if}
    </div>
</nav>