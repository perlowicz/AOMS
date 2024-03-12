import {TextField} from "@mui/material";


export default function CompanyAddressStreetInput(){
    return (
        <TextField
            required
            id="street"
            label="Ulica"
            variant="outlined"
        />
    );
}