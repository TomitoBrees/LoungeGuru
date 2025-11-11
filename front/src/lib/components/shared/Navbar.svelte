<script>
    import User from "phosphor-svelte/lib/user";
    import SignOut from "phosphor-svelte/lib/SignOut";
    import {goto, invalidateAll} from "$app/navigation";

    let { user } = $props();

    function getInitials() {
        return user.firstName.charAt(0) + user.lastName.charAt(0);
    }

    async function logout() {
        await fetch('/api/logout', { method: 'POST' });
        await invalidateAll();
        goto('/');
    }
</script>

<div class="border-b-base-300 border-b-1">
    <nav class="flex justify-between items-center mx-24">
        <div class="flex gap-4 items-center justify-center">
            <img src="/logo.png" alt="logo of the website" width="61" height="61"/>
            <h1 class="text-4xl font-semibold">LoungeGuru</h1>
        </div>
        <div>
            <button class="btn btn-lg btn-ghost">Reservations</button>

            {#if user}
                <div class="dropdown dropdown-end">
                    <div tabindex="0" role="button"  class="avatar avatar-placeholder cursor-pointer">
                        <div class="bg-accent text-neutral-content w-10 rounded-full">
                            <span class="text-md">{getInitials()}</span>
                        </div>
                    </div>
                    <ul class="dropdown-content menu bg-base-100 rounded-box z-1 w-52 p-2 mt-2 shadow-md border border-base-200">
                        <li>
                            <button class="group text-accent hover:bg-accent hover:text-accent-content" role="link">
                                <User class="text-accent group-hover:text-accent-content"/>
                                Profile
                            </button>
                        </li>
                        <li>
                            <button class="group text-error hover:bg-error hover:text-error-content" onclick={logout}>
                                <SignOut class="text-error group-hover:text-error-content" />
                                Logout
                            </button>
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
</div>