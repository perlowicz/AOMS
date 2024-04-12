import './App.css';
import React, {useState} from "react";
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

function App() {
    return (
        <AuthProvider>
            <BrowserRouter>
                <Navbar/>
                <Routes>
                    <Route path="/" element=<Home/>/>
                    <Route path="/register" element=<Registration/>/>
                    <Route path="/login" element=<Login/>/>
                    <Route
                        path="/profile"
                        element={
                            <ProtectedRoute>
                                <CompanyProfile/>
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
