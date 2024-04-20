import React, { useContext } from 'react';
import { Navigate, useLocation } from 'react-router-dom';
import { CompanyContext } from '../context/CompanyContext';
import {LOGIN, ADD_PROFILE} from "../utils/routePaths";

const ProtectedRoute = ({ children }) => {
    const location = useLocation();
    const isAuthenticated = localStorage.getItem('isAuthenticated') === 'true';
    const accessToken = localStorage.getItem('access_token');
    const refreshToken = localStorage.getItem('refresh_token');
    const companyInfo = useContext(CompanyContext);

    if (!isAuthenticated || !accessToken || !refreshToken) {
        return <Navigate to={LOGIN} />
    }

    // if (!companyInfo && location.pathname !== ADD_PROFILE) {
    //     return <Navigate to={ADD_PROFILE} state={{ message: 'Aby kontynuować wprowadź dane dotyczące twojej firmy' }} />
    // }

    return children;
};

export default ProtectedRoute;