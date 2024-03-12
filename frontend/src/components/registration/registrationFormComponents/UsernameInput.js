import {TextField} from "@mui/material";

export default function UsernameInput() {
    return (
        <TextField
            required
            id="username-input"
            label="Nazwa użytkownika"
            variant="outlined"
        />
    );
}