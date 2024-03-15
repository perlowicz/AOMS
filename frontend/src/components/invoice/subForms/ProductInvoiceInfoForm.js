import Box from "@mui/material/Box";
import Typography from "@mui/material/Typography";
import Button from "@mui/material/Button";
import {Divider, TextField} from "@mui/material";
import {useState} from "react";
import {AdapterDayjs} from "@mui/x-date-pickers/AdapterDayjs";
import {DatePicker} from "@mui/x-date-pickers/DatePicker";
import {LocalizationProvider} from "@mui/x-date-pickers";


export default function ProductInvoiceInfoForm( {handleNext} ) {

    const [listOfProductInvoiceInfo, setListOfProductInvoiceInfo] = useState([{
        name: "",
        quantity: "",
        bruttoPrice: "",
        nettoPrice: "" ,
        date: "",
        productType: ""
    }]);

    const addProduct = () => {
        setListOfProductInvoiceInfo([...listOfProductInvoiceInfo, {
            name: "",
            quantity: "",
            bruttoPrice: "",
            nettoPrice: "",
            date: "",
            productType: ""
        }]);
    };

    const removeProduct = (index) => {
        const newProducts = [...listOfProductInvoiceInfo];
        newProducts.splice(index, 1);
        setListOfProductInvoiceInfo(newProducts);
    };

    const handleProductChange = (event, index) => {
        const newProducts = [...listOfProductInvoiceInfo];
        newProducts[index][event.target.name] = event.target.value;
        setListOfProductInvoiceInfo(newProducts);
    };

    const handleDateChange = (selectedDate, index) => {
        const newProducts = [...listOfProductInvoiceInfo];
        newProducts[index].date = selectedDate;
        setListOfProductInvoiceInfo(newProducts);
    };

    const handleSubmit = (event) => {
        event.preventDefault();
        const productInvoiceInfoData = listOfProductInvoiceInfo.map(product => ({
            name: product.name,
            quantity: product.quantity,
            bruttoPrice: product.bruttoPrice,
            nettoPrice: product.nettoPrice,
            date: product.date.toISOString,
            productType: {
                type: product.productType
            }
        }));
        handleNext({ listOfProductInvoiceInfo: productInvoiceInfoData });
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
            {listOfProductInvoiceInfo.map((product, index) => (
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
                            onChange={(selectedDate) => handleDateChange(selectedDate, index)}
                        />
                    </LocalizationProvider>
                    <TextField
                        // TODO Uncomment required attribute
                        //required
                        name="productType"
                        label="Typ towaru"
                        value={product.productType}
                        onChange={(event) => handleProductChange(event, index)}
                    />
                    <Button onClick={() => removeProduct(index)}>Usuń towar</Button>
                </div>
            ))}
            <Divider/>
            <Button onClick={addProduct}>Dodaj towar</Button>
            <Button
                type="submit"
            >
                Dalej
            </Button>
        </Box>
    );
}