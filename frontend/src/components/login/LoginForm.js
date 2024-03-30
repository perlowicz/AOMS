import axios from "axios";
import Box from "@mui/material/Box";
import Button from "@mui/material/Button";
import {useContext, useState} from "react";
import {Alert, AlertTitle, TextField} from "@mui/material";
import { useNavigate } from 'react-router-dom';
import {AuthContext} from "../AuthContext";


export default function LoginForm() {

    const navigate = useNavigate();
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [alertOpen, setAlertOpen] = useState(false);
    const { handleLogin } = useContext(AuthContext);

    const handleSubmit = async (event) => {
        event.preventDefault();

        const userData = {
            email: email,
            password: password,
        }

        try {
            const response = await axios.post('http://localhost:8080/api/user/login', userData);
            if (response.status === 200) {
                localStorage.setItem('token', response.data.access_token);
                navigate('/?logged=true');
                handleLogin();
            } else {
                setAlertOpen(true);
            }
        } catch (error) {
            setAlertOpen(true);
        }
    }

    return (
        <Box
            component="form"
            onSubmit={handleSubmit}
            autoComplete="off"
            sx={{
                display: 'flex',
                flexDirection: 'column',
                justifyContent: 'center',
                gap: 2,
                width: '100%',
                margin: 'auto',
                // padding: '20px',
                borderRadius: '10px'
            }}
        >
            <TextField
                required
                id="email-input"
                label="Email"
                variant="outlined"
                value={email}
                onChange={e => setEmail(e.target.value)}
            />
            <TextField
                required
                id="password-input"
                label="Hasło"
                type="password"
                autoComplete="current-password"
                value={password}
                onChange={e => setPassword(e.target.value)}
            />
            {alertOpen &&
                <Alert severity="error">
                    <AlertTitle>Nie udało się zalogować</AlertTitle>
                    Niepoprawne dane logowania.
                </Alert>
            }
            <Button
                type="submit"
                variant="contained"
            >
                Zatwiedź
            </Button>
        </Box>
    );
}