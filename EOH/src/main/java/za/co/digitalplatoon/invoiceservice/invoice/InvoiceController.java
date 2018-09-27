package za.co.digitalplatoon.invoiceservice.invoice;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

	@Autowired
	private InvoiceRepository invoiceRepository;
	
	@PostMapping("/addInvoice")
	public Invoice addInvoice(@RequestBody Invoice invoice){

		invoice.setClient("Kholo");
		invoice.setVatRate((long) 15);
		invoice.setInvoiceDate(new Date());

		return invoiceService.save(invoice);
	}
	

	@GetMapping("/allInvoices")
	public List<Invoice> viewAllInvoices(){

		return invoiceRepository.findAll();
	}
	
	@RequestMapping("/getInvoice/{invoiceId}")
	public Invoice viewInvoice(@PathVariable Long invoiceId){

		return invoiceRepository.getOne(invoiceId)

	}
	
}
