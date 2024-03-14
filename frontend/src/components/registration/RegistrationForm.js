import Box from "@mui/material/Box";
import Button from "@mui/material/Button";
import axios from "axios";
import UsernameInput from "./registrationFormComponents/UsernameInput";
import PasswordInput from "./registrationFormComponents/PasswordInput";
import EmailInput from "./registrationFormComponents/EmailInput";


export default function RegistrationForm() {



    const handleSubmit = async (event) => {
        event.preventDefault();

        const formData = {
            userName: event.target[0].value,
            email: event.target[2].value,
            password: event.target[4].value
        };

        try {
            const response = await axios.post('http://localhost:8080/api/register', formData);
            if (response.status === 200 || response.status === 201) {
                console.log('Registration successful');
            } else {
                console.log('Registration failed');
            }
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