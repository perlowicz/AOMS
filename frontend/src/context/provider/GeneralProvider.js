import React from 'react';
import { AuthProvider } from '../AuthContext';

export const GeneralProvider = ({ children }) => {
    return (
        <AuthProvider>
            {children}
        </AuthProvider>
    );
};