import Box from "@mui/material/Box";
import Typography from "@mui/material/Typography";
import Button from "@mui/material/Button";


export default function ServiceInvoiceInfoForm( {handleNext} ) {


    const handleSubmit = (event) => {
        event.preventDefault();
        handleNext();
    };

    return (
        <Box
            component="form"
            onSubmit={handleSubmit}
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
            <Typography
                variant="h4"
                align="center"
            >
                Usługi na fakturze
            </Typography>
            <Button
                type="submit"
            >
                Next
            </Button>
        </Box>
    );
}