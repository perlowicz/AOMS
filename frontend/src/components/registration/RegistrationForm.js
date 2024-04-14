import Box from "@mui/material/Box";
import Button from "@mui/material/Button";
import axios from "axios";
import { useNavigate } from 'react-router-dom';
import {useState} from "react";
import {TextField} from "@mui/material";


export default function RegistrationForm() {

    const navigate = useNavigate();
    const [username, setUsername] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const handleSubmit = async (event) => {
        event.preventDefault();

        const formData = {
            username: username,
            email: email,
            password: password
        };

        try {
            const response = await axios.post('http://localhost:8080/api/user/register', formData);
            if (response.status === 200) {
                navigate('/check-email');
            }
        } catch (error) {
            console.log('Api zwróciło błędną odpowiedź');
            console.log(error);
            navigate('/?registered=false');
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
            <Button
                type="submit"
                variant="contained"
            >
                Zatwiedź
            </Button>
        </Box>
    );
}