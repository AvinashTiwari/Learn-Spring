package com.learncamel.process;

import com.learncamel.domain.Item;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

/**
 * Created by z001qgd on 2/3/18.
 */
@Component
@Slf4j
public class BuildSQLProcessor implements org.apache.camel.Processor {
    @Override
    public void process(Exchange exchange) throws Exception {

        Item item = (Item) exchange.getIn().getBody();
        log.info(" Item in Processor is : " + item);

        StringBuilder query = new StringBuilder();
        if(item.getTransactionType().equals("ADD")){
            query.append("INSERT INTO ITEMS (SKU, ITEM_DESCRIPTION,PRICE) VALUES ('");
            query.append(item.getSku()+"','"+item.getItemDescription()+"','"+item.getPrice()+")");

        }else if(item.getTransactionType().equals("UPDATE")){

        }else if(item.getTransactionType().equals("DELETE")){

        }
        log.info("Final Query is : " + query);
        exchange.getIn().setBody(query.toString());

    }
}
