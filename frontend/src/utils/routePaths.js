export const BACKEND_URL = "http://localhost:8080/api";

export const FRONTEND_ENDPOINTS = {
    HOME:  "/",
    REGISTER: "/register",
    LOGIN: "/login",
    CHECK_EMAIL: "/check-email",
    ACTIVATE_ACCOUNT: "/activate-account",
    PROFILE: "/profile",
    ADD_PROFILE: "/add-profile",
    ADD_INVOICE: "/add-invoice",
    INVOICES: "/invoices"
}

export const BACKEND_ENDPOINTS = {
    USER_REGISTRATION: `${BACKEND_URL}/user/register`,
    USER_LOGIN: `${BACKEND_URL}/user/login`,
    GET_ALL_INVOICES: `${BACKEND_URL}/invoice/all`,
}