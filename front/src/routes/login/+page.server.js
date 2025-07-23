import {redirect} from "@sveltejs/kit";

/** @satisfies {import('./$types').Actions} */
export const actions = {
    default: async ({ cookies, request, fetch }) => {
        const data = await request.formData();
        const email = data.get('email');
        const password = data.get('password');

        console.log(email);
        console.log(password);

        const res = await fetch('http://localhost:8080/users/login', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ email, password })
        })

        console.log(res);

        if (res.ok) {
            const body = await res.json();

            cookies.set('accessToken', body.accessToken, {
                path: '/',
                httpOnly: false,
                sameSite: 'strict',
                maxAge: 60 * 60,
                secure: false
            });

            throw redirect(303, '/');
        }
        else {
            return { success: false, error: 'Invalid login' };
        }
    }
};