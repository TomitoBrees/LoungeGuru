export async function refreshUser(cookies, fetch) {
    let token = cookies.get('accessToken');

    if (!token) {
        const refreshingRes = await fetch('http://localhost:8080/users/refresh', {
            method: 'POST',
            credentials: 'include'
        });

        if (refreshingRes.ok) {
            const refreshingData = await refreshingRes.json();
            token = refreshingData.accessToken;

            cookies.set('accessToken', token, {
                path: '/',
                httpOnly: false,
                sameSite: 'strict',
                maxAge: 60 * 60,
                secure: false
            });
        } else {
            return null;
        }
    }

    try {
        const [, payload] = token.split('.');
        const decoded = JSON.parse(atob(payload));
        return decoded;
    } catch (err) {
        return { user: null };
    }
}