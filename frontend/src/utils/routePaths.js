export const BACKEND_URL = "http://localhost:8080/api";

export const FRONTEND_ENDPOINTS = {
    HOME:  "/",
    REGISTER: "/register",
    LOGIN: "/login",
    CHECK_EMAIL: "/check-email",
    ACTIVATE_ACCOUNT: "/activate-account",
    PROFILE: "/profile",
    ADD_INVOICE: "/add-invoice",
    INVOICES: "/invoices"
}

export const BACKEND_ENDPOINTS = {
    USER_REGISTRATION: `${BACKEND_URL}/user/register`,
    ACTIVATE_ACCOUNT: `${BACKEND_URL}/user/register/verifyEmail`,
    USER_LOGIN: `${BACKEND_URL}/user/login`,
    GET_ALL_INVOICES: `${BACKEND_URL}/invoice/all`,
    SAVE_INVOICE: `${BACKEND_URL}/invoice/save`,
    GET_ALL_COUNTRIES: `${BACKEND_URL}/country/all`,
}