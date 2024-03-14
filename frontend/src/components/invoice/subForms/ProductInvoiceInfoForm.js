import Box from "@mui/material/Box";
import Typography from "@mui/material/Typography";
import Button from "@mui/material/Button";
import {TextField} from "@mui/material";
import {useState} from "react";
import {AdapterDayjs} from "@mui/x-date-pickers/AdapterDayjs";
import {DatePicker} from "@mui/x-date-pickers/DatePicker";
import {LocalizationProvider} from "@mui/x-date-pickers";


export default function ProductInvoiceInfoForm( {handleNext} ) {

    const [products, setProducts] = useState([{ name: "", quantity: "", price: "", bruttoPrice: "", nettoPrice: "" }]);

    const addProduct = () => {
        setProducts([...products, { name: "", quantity: "", price: "", bruttoPrice: "", nettoPrice: "" }]);
    };

    const removeProduct = (index) => {
        const newProducts = [...products];
        newProducts.splice(index, 1);
        setProducts(newProducts);
    };

    const handleProductChange = (event, index) => {
        const newProducts = [...products];
        newProducts[index][event.target.name] = event.target.value;
        setProducts(newProducts);
    };

    const handleSubmit = (event) => {
        event.preventDefault();
        handleNext(products);
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
                Towary na fakturze
            </Typography>
            {products.map((product, index) => (
                <div key={index}>
                    <TextField
                        // TODO Uncomment required attribute
                        //required
                        name="name"
                        label="Nazwa produktu"
                        value={product.name}
                        onChange={(event) => handleProductChange(event, index)}
                    />
                    <TextField
                        // TODO Uncomment required attribute
                        //required
                        name="quantity"
                        label="Ilość"
                        type="number"
                        value={product.quantity}
                        onChange={(event) => handleProductChange(event, index)}
                    />
                    <TextField
                        // TODO Uncomment required attribute
                        //required
                        name="bruttoPrice"
                        label="Cena brutto"
                        type="number"
                        value={product.bruttoPrice}
                        onChange={(event) => handleProductChange(event, index)}
                    />
                    <TextField
                        // TODO Uncomment required attribute
                        //required
                        name="nettoPrice"
                        label="Cena netto"
                        type="number"
                        value={product.nettoPrice}
                        onChange={(event) => handleProductChange(event, index)}
                    />
                    <LocalizationProvider dateAdapter={AdapterDayjs}>
                        <DatePicker
                            label="Data dostarczenia towaru"
                            value={product.date}
                            onChange={(event) => handleProductChange(event, index)}
                        />
                    </LocalizationProvider>
                    <Button onClick={() => removeProduct(index)}>Usuń towar</Button>
                </div>
            ))}
            <Button onClick={addProduct}>Dodaj towar</Button>
            <Button
                type="submit"
            >
                Dalej
            </Button>
        </Box>
    );
}