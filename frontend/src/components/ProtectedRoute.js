import {Navigate} from "react-router-dom";
import {useEffect, useState} from "react";
import axios from "axios";
import {LinearProgress} from "@mui/material";


export default function ProtectedRoute ({ children }) {

    const [isLoading, setIsLoading] = useState(true);
    const [isAuthenticated, setIsAuthenticated] = useState(false);

    //FIXME Trzeba w każdym page przy wysyłaniu requestu doklejać w nagłówku token jwt i na backendzie na endpoincie
    // authoryzować go.

    return children;
}