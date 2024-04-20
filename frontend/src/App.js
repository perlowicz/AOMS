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
import ProtectedRoute from "./components/ProtectedRoute";
import AddCompanyProfile from "./pages/AddCompanyProfile";
import CheckEmail from "./pages/CheckEmail";
import ActivateAccount from "./pages/ActivateAccount";
import {GeneralProvider} from "./context/provider/GeneralProvider";
import {FRONTEND_ENDPOINTS} from "./utils/routePaths";

function App() {
    return (
        <GeneralProvider>
            <BrowserRouter>
                {/*<CompanyProvider>*/}
                    <Navbar/>
                    <Routes>
                        <Route path={FRONTEND_ENDPOINTS.HOME} element={<Home/>}/>
                        <Route path={FRONTEND_ENDPOINTS.REGISTER} element={<Registration/>}/>
                        <Route path={FRONTEND_ENDPOINTS.LOGIN} element={<Login/>}/>
                        <Route path={FRONTEND_ENDPOINTS.CHECK_EMAIL} element={<CheckEmail/>}/>
                        <Route path={FRONTEND_ENDPOINTS.ACTIVATE_ACCOUNT} element={<ActivateAccount/>}/>
                        <Route
                            path={FRONTEND_ENDPOINTS.PROFILE}
                            element={
                                <ProtectedRoute>
                                    <CompanyProfile/>
                                </ProtectedRoute>}

                        />
                        <Route
                            path={FRONTEND_ENDPOINTS.PROFILE}
                            element={
                                <ProtectedRoute>
                                    <CompanyProfile/>
                                </ProtectedRoute>}

                        />
                        <Route
                            path={FRONTEND_ENDPOINTS.ADD_PROFILE}
                            element={
                                <ProtectedRoute>
                                    <AddCompanyProfile/>
                                </ProtectedRoute>
                            }
                        />
                        <Route
                            path={FRONTEND_ENDPOINTS.ADD_INVOICE}
                            element={
                                <ProtectedRoute>
                                    <AddInvoice/>
                                </ProtectedRoute>
                            }
                        />
                        <Route
                            path={FRONTEND_ENDPOINTS.INVOICES}
                            element={
                                <ProtectedRoute>
                                    <Invoices/>
                                </ProtectedRoute>
                            }
                        />
                    </Routes>
                {/*</CompanyProvider>*/}
            </BrowserRouter>
        </GeneralProvider>
    );
}

export default App;
