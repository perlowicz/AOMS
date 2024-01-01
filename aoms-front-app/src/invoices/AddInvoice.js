import React, {useState} from "react";

export default function AddInvoice() {

    const [invoice, setInvoice] = useState({
        invoiceNumber:"",
        // FIXME The missing inputs that will come here from form should be added.
    })

    const{
        invoiceNumber,
        // FIXME The missing inputs that will come here from form should be added.
    } = invoice

    const onInputChange = (e) => {
        setInvoice({...invoice, [e.target.invoiceNumber] : e.target.value});
    }


    return (
        <div className="container">
            <div className="row">
                <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
                    <h2 className="text-center m-4">Register Invoice</h2>
                    {/*
                FIXME The div below represents one input from form, missing inputs should be added.
                */}
                    <div className="mb-3">
                        <label htmlFor="invoiceNumber" className="form-label">
                            Invoice Number
                        </label>
                        <input
                            type={"text"}
                            className="form-control"
                            placeholder="Enter Invoice Number"
                            name="invoiceNumber"
                            value={invoiceNumber}
                            onChange={(e) => onInputChange(e)}
                        />
                    </div>
                    <button type="submit" className="btn btn-outline-primary">Submit</button>
                    <button type="submit" className="btn btn-outline-danger mx-2">Cancel</button>
                </div>
            </div>
        </div>
    );
}