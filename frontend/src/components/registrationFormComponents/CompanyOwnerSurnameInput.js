import {TextField} from "@mui/material";


export default function CompanyOwnerSurnameInput() {
    return (
        <TextField
            id="company-owner-surname-input"
            label="Nazwisko właściciela"
            variant="outlined"
            required
        />
    );
}