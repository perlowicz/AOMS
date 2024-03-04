import {TextField} from "@mui/material";


export default function CompanyOwnerNameInput() {
    return (
        <TextField
            id="company-owner-name-input"
            label="Imię właściciela"
            variant="outlined"
            required
        />
    );
}