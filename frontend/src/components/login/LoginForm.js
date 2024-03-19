import axios from "axios";
import Box from "@mui/material/Box";
import Button from "@mui/material/Button";
import {useState} from "react";
import {Alert, AlertTitle, TextField} from "@mui/material";
import { useNavigate } from 'react-router-dom';


export default function LoginForm() {

    const navigate = useNavigate();
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [alertOpen, setAlertOpen] = useState(false);

    const handleSubmit = async (event) => {
        event.preventDefault();

        const userData = {
            username: username,
            password: password,
        }

        try {
            const response = await axios.post('http://localhost:8080/api/user/login', userData);
            if (response.status === 200) {
                localStorage.setItem('sessionToken', response.data);
                navigate('/?logged=true');
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
            {alertOpen &&
                <Alert severity="error">
                    <AlertTitle>Nie udało się zalogować</AlertTitle>
                    Niepoprawne dane logowania.
                </Alert>
            }
            <TextField
                required
                id="username-input"
                label="Nazwa użytkownika"
                variant="outlined"
                value={username}
                onChange={e => setUsername(e.target.value)}
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
            <Button
                type="submit"
                variant="contained"
            >
                Zatwiedź
            </Button>
        </Box>
    );
}