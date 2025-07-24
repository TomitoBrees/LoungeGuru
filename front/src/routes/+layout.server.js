/** @type {import('./$types').LayoutServerLoad} */
export async function load({ cookies, fetch }) {
    let token = cookies.get('accessToken');

    if (!token) {
        const res = await fetch('http://localhost:8080/users/refresh', {
            method: 'POST',
            credentials: 'include'
        });

        if (res.ok) {
            const data = await res.json();
            token = data.accessToken;

            cookies.set('accessToken', token, {
                path: '/',
                httpOnly: false,
                sameSite: 'strict',
                maxAge: 60 * 60,
                secure: false
            });
        } else {
            return { user: null };
        }
    }

    try {
        const [, payload] = token.split('.');
        const decoded = JSON.parse(atob(payload));
        return { user: decoded };
    } catch (err) {
        return { user: null };
    }
}