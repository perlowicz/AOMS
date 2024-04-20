import React from 'react';
import { Navigate } from 'react-router-dom';
import {FRONTEND_ENDPOINTS} from "../utils/routePaths";

const ProtectedRoute = ({ children }) => {
    const isAuthenticated = localStorage.getItem('isAuthenticated') === 'true';
    const accessToken = localStorage.getItem('access_token');
    const refreshToken = localStorage.getItem('refresh_token');

    if (!isAuthenticated || !accessToken || !refreshToken) {
        return <Navigate to={FRONTEND_ENDPOINTS.LOGIN} />
    }
    return children;
};

export default ProtectedRoute;