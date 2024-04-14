import './App.css';
import React from "react";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import Home from "./pages/Home";
import AddInvoice from "./pages/AddInvoice";
import CompanyProfile from "./pages/CompanyProfile";
import Registration from "./pages/Registration";
import Invoices from "./pages/Invoices";
import Login from "./pages/Login";
import Navbar from "./components/navigation/Navbar";
import {AuthProvider} from "./context/AuthContext";
import ProtectedRoute from "./components/ProtectedRoute";
import AddCompanyProfile from "./pages/AddCompanyProfile";
import CheckEmail from "./pages/CheckEmail";
import ActivateAccount from "./pages/ActivateAccount";

function App() {
    return (
        <AuthProvider>
            <BrowserRouter>
                <Navbar/>
                <Routes>
                    <Route path="/" element=<Home/>/>
                    <Route path="/register" element=<Registration/>/>
                    <Route path="/login" element=<Login/>/>
                    <Route path="/check-email" element=<CheckEmail/>/>
                    <Route path="/activate-account" element=<ActivateAccount/>/>
                    <Route
                        path="/profile"
                        element={
                            <ProtectedRoute>
                                <CompanyProfile/>
                            </ProtectedRoute>}

                    />
                    <Route
                        path="/add-profile"
                        element={
                            <ProtectedRoute>
                                <AddCompanyProfile/>
                            </ProtectedRoute>}

                    />
                    <Route
                        path="/add-invoice"
                        element={
                            <ProtectedRoute>
                                <AddInvoice/>
                            </ProtectedRoute>
                        }
                    />
                    <Route
                        path="/invoices"
                        element={
                            <ProtectedRoute>
                                <Invoices/>
                            </ProtectedRoute>
                        }
                    />
                </Routes>
            </BrowserRouter>
        </AuthProvider>
    );
}

export default App;
