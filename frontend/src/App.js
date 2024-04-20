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
import * as ROUTES from './utils/routePaths';
import {CompanyProvider} from "./context/provider/CompanyProvider";

function App() {
    return (
        <GeneralProvider>
            <BrowserRouter>
                {/*<CompanyProvider>*/}
                    <Navbar/>
                    <Routes>
                        <Route path={ROUTES.HOME} element={<Home/>}/>
                        <Route path={ROUTES.REGISTER} element={<Registration/>}/>
                        <Route path={ROUTES.LOGIN} element={<Login/>}/>
                        <Route path={ROUTES.CHECK_EMAIL} element={<CheckEmail/>}/>
                        <Route path={ROUTES.ACTIVATE_ACCOUNT} element={<ActivateAccount/>}/>
                        <Route
                            path={ROUTES.PROFILE}
                            element={
                                <ProtectedRoute>
                                    <CompanyProfile/>
                                </ProtectedRoute>}

                        />
                        <Route
                            path={ROUTES.PROFILE}
                            element={
                                <ProtectedRoute>
                                    <CompanyProfile/>
                                </ProtectedRoute>}

                        />
                        <Route
                            path={ROUTES.ADD_PROFILE}
                            element={
                                <ProtectedRoute>
                                    <AddCompanyProfile/>
                                </ProtectedRoute>
                            }
                        />
                        <Route
                            path={ROUTES.ADD_INVOICE}
                            element={
                                <ProtectedRoute>
                                    <AddInvoice/>
                                </ProtectedRoute>
                            }
                        />
                        <Route
                            path={ROUTES.INVOICES}
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
