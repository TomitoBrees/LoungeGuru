<script>
    import {enhance} from "$app/forms";

    let {form} = $props()
</script>

<div class="flex min-h-screen w-full items-center justify-center gap-16">

    <div class="card bg-base-200 shadow-sm w-[470px] h-[600px] hidden md:block">
        <figure class="bg-[#0488E3]">
            <img
                    src="/illustrations/login-illustration.png"
                    alt="login-illustration"
                    class="w-80"
            />
        </figure>
        <div class="card-body">
            <h2 class="card-title">Card Title</h2>
            <p>A card component has a figure, a body part, and inside body there are title and actions parts</p>
        </div>
    </div>

    <div>

        {#if form?.error}
            <div class="toast toast-top toast-left">
                <div class="alert alert-error">
                    <span>{form?.error}</span>
                </div>
            </div>
        {/if}

        <form method="POST" use:enhance>
            <fieldset class="fieldset rounded-box w-sm p-4">

                <label class="label" for="email">Email</label>

                <div class="indicator">
                    <span class="indicator-item badge">Required</span>
                    <input type="email" class="input validator w-sm" placeholder="Email" name="email" id="email" required/>
                </div>

                <label class="label" for="password">Password</label>

                <div class="indicator">
                    <span class="indicator-item badge">Required</span>
                    <input type="password" class="input validator w-sm" placeholder="Password" name="password" id="password" required/>
                </div>

                <button class="btn btn-primary mt-4">Login</button>
            </fieldset>
        </form>

        <div class="divider">OR</div>

        <form>
            <fieldset class="fieldset rounded-box w-sm p-4 pt-0">

                <div class="flex fieldset">
                    <div class="fieldset">
                        <label class="label">First Name</label>
                        <input type="text" class="input" placeholder="First Name"/>
                    </div>

                    <div class="fieldset">
                        <label class="label">Last Name</label>
                        <input type="text" class="input" placeholder="Last Name"/>
                    </div>
                </div>

                <label class="label">Email</label>
                <input type="email" class="input w-sm" placeholder="Email"/>

                <label class="label">Password</label>
                <input type="password" class="input w-sm" placeholder="Password"/>

                <button class="btn btn-accent mt-4">Sign Up</button>
            </fieldset>
        </form>
    </div>
</div>