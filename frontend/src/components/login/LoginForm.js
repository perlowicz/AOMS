import axios from "axios";
import Box from "@mui/material/Box";
import Button from "@mui/material/Button";
import {useState} from "react";
import {TextField} from "@mui/material";


export default function LoginForm() {

    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    const handleSubmit = async (event) => {
        event.preventDefault();

        const userData = {
            username: username,
            password: password,
        }

        try {
            const response = await axios.post('http://localhost:8080/api/login', userData);
            localStorage.setItem('sessionToken', response.data.token);
        } catch (error) {
            console.log(error);
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