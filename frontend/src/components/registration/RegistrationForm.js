import Box from "@mui/material/Box";
import Button from "@mui/material/Button";
import axios from "axios";
import UsernameInput from "../formComponents/UsernameInput";
import PasswordInput from "../formComponents/PasswordInput";
import EmailInput from "../formComponents/EmailInput";
import { useNavigate } from 'react-router-dom';


export default function RegistrationForm() {

    const navigate = useNavigate();

    const handleSubmit = async (event) => {
        event.preventDefault();

        const formData = {
            userName: event.target[0].value,
            email: event.target[2].value,
            password: event.target[4].value
        };

        try {
            const response = await axios.post('http://localhost:8080/api/register', formData);
            if (response.status === 200) {
                navigate('/?registered=true');
            }
        } catch (error) {
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
            <UsernameInput/>
            <EmailInput/>
            <PasswordInput/>
            <Button
                type="submit"
                variant="contained"
            >
                Zatwiedź
            </Button>
        </Box>
    );
}