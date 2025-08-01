import {redirect} from "@sveltejs/kit";
import { fail } from '@sveltejs/kit';

/** @satisfies {import('./$types').Actions} */
export const actions = {
    login: async ({ cookies, request, fetch }) => {
        const data = await request.formData();
        const email = data.get('email');
        const password = data.get('password');

        const res = await fetch('http://localhost:8080/users/login', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ email, password }),
            credentials: 'include'
        })

        if (res.ok) {
            const body = await res.json();

            cookies.set('accessToken', body.accessToken, {
                path: '/',
                httpOnly: false,
                sameSite: 'strict',
                maxAge: 60 * 60,
                secure: false
            });

            cookies.set('refreshToken', body.refreshToken, {
                path: '/',
                httpOnly: false,
                sameSite: 'strict',
                maxAge: 30 * 24 * 60 * 60,
                secure: false
            });

            throw redirect(303, '/');
        }
        else {
            return fail(400, {
                description: "Invalid username or password",
                error: "Invalid username or password"
            })
        }
    },

    register: async ({ cookies, request, fetch }) => {
        const data = await request.formData();
        const email = data.get('registerEmail');
        const password = data.get('registerPassword');
        const firstName = data.get('firstName');
        const lastName = data.get('lastName')

        const create = await fetch('http://localhost:8080/users', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ email, password, firstName, lastName }),
            credentials: 'include'
        })

        if (create.ok) {

            const login = await fetch('http://localhost:8080/users/login', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ email, password }),
                credentials: 'include'
            })

            if (login.ok) {
                const body = await login.json();

                cookies.set('accessToken', body.accessToken, {
                    path: '/',
                    httpOnly: false,
                    sameSite: 'strict',
                    maxAge: 60 * 60,
                    secure: false
                });

                cookies.set('refreshToken', body.refreshToken, {
                    path: '/',
                    httpOnly: false,
                    sameSite: 'strict',
                    maxAge: 30 * 24 * 60 * 60,
                    secure: false
                });

                throw redirect(303, '/');
            }
            else {
                return fail(400, {
                    description: "Invalid username or password",
                    error: "Invalid username or password"
                })
            }
        }
        else {
            return fail(400, {
                description: "Could not create user",
                error: "Could not create user"
            })
        }
    }
};