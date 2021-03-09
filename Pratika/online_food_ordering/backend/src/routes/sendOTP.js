module.exports = function(app, nodemailer) {

    app.post("/send", (req, res) => {
        main(req).catch(console.error);
        res.json({success: true, msg: 'sent'});
    });

    async function main(req) {
        let transporter = nodemailer.createTransport({
            host: "172.27.172.202",
            port: 25,
            secure: false, // true for 465, false for other ports
            auth: {
                user: 'CEL@evolvingsols.com', // generated ethereal user
                pass: 'Gmail#@5689' // generated ethereal password
            },
            tls: {
                // do not fail on invalid certs
                rejectUnauthorized: false
            }
        });

        
        let cEmail = req.body.email;
        let restaurantName = req.body.restName;
        let orderId = req.body.oid;
        let otp = req.body.otp;
        let delName = req.body.delName;
        let vNo = req.body.vNo;
        let amount = req.body.amount;
        let date = req.body.date;
        let time = req.body.time;
        //orderitems "email": email, "restName":order.restaurant.name, "oid": order.oid, "otp":otp, "delName": deliveryperson.name, "vNo": deliveryperson.vehicleno, "amount": order.price, "date": order.orderdate, "time": order.ordertime

        let message = `
        <!DOCTYPE html>
        <html>
        <body>
        <p class="lead">Hello,</p>
        <p class="lead">Your order has been accepted by ${restaurantName} on ${date} at ${time}.</p>
        <div class="lead">
            <p class="">Order Number: ${orderId}</p>
            <p>Delivery Executive Name:<br>${delName}</p>
            <p>Vehicle Number:<br>${vNo}</p>
            <p>Amount:<br>Rs. ${amount}</p>
        </div>
        <p class="h5">OTP: ${otp}</p>
        </body>
        </html>
        `;

        let mailOptions = {
            from: '"Foodify" <CEL@evolvingsols.com>', // sender address
            to: cEmail, // list of receivers
            subject: `Your order from ${restaurantName} for order no. ${orderId}`, // Subject line
            html: message, // html body
        }
    
        // send mail with defined transport object
        let info = await transporter.sendMail(mailOptions);
        console.log("Message sent: %s", info.messageId);
        console.log("Preview URL: %s", nodemailer.getTestMessageUrl(info));
    }
    
}
