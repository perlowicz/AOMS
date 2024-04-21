import React from 'react';
import { AuthProvider } from '../AuthContext';
import {InvoicesProvider} from "../InvoiceContext";

export const GeneralProvider = ({ children }) => {
    return (
        <AuthProvider>
            <InvoicesProvider>
                {children}
            </InvoicesProvider>
        </AuthProvider>
    );
};