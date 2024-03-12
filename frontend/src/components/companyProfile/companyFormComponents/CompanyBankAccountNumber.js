import {TextField} from "@mui/material";


export default function CompanyBankAccountNumber() {
    return (
        <TextField
            required
            id="bankAccountNumber"
            label="Numer konta bankowego"
            variant="outlined"
        />
    );
}