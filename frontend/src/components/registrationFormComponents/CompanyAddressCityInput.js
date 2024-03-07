import {TextField} from "@mui/material";


export default function CompanyAddressCityInput() {
    return (
        <TextField
            required
            id="city"
            label="Miejscowość"
            variant="outlined"
        />
    );
}