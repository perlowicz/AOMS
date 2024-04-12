import {useState, useEffect, useContext} from 'react';
import axios from 'axios';
import {AuthContext} from "../context/AuthContext";

const useAxios = (endpoint, options) => {
    const [data, setData] = useState(null);
    const [error, setError] = useState(null);
    const [loading, setLoading] = useState(true);
    const { handleLogout } = useContext(AuthContext);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await axios.get(`http://localhost:8080/api/${endpoint}`, options);
                setData(response.data);
            } catch (error) {
                handleLogout();
                setError(error);
            } finally {
                setLoading(false);
            }
        };
        fetchData();
    }, [endpoint, handleLogout, options]);

    return { data, error, loading };
};

export default useAxios;