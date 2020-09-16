package springweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import springweb.domain.BaseResponse;
import springweb.exception.CarNotFoundException;
import springweb.service.CarService;
import springweb.util.BaseResponses;


/**
 * CarController.
 *
 * @author Archon  2019/8/28
 * @since 0.1
 */
@RestController
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars/{name}")
    private BaseResponse getCar(@PathVariable String name) throws CarNotFoundException {
        return BaseResponses.ok(carService.getCarDetails(name));
    }

    @GetMapping("/cars")
    private BaseResponse getAllCars() throws CarNotFoundException {
        return BaseResponses.ok(carService.getAllCars());
    }

    @PostMapping("/matrix")
    private Object matrix(@RequestBody Object request) {
        return "{\n" + "    \"code\": 0,\n" + "    \"success\": true,\n" + "    \"message\": \"success\",\n" + "    \"data\": {\n"
            + "        \"meta\": {\n" + "            \"version\": null,\n" + "            \"datasourceId\": null,\n"
            + "            \"datasetType\": \"list\",\n" + "            \"measures\": [],\n" + "            \"parameters\": [\n"
            + "                {\n" + "                    \"schemeField\": \"customer_id\",\n" + "                    \"apiParam\": \"企业id\"\n"
            + "                }\n" + "            ],\n" + "            \"fieldsInfo\": [\n" + "                {\n"
            + "                    \"fieldName\": \"id\",\n" + "                    \"fieldAlias\": \"HEAD表ID\",\n"
            + "                    \"fieldIsNested\": 0,\n" + "                    \"fieldIsArray\": 0,\n"
            + "                    \"fieldIsAnalyzed\": 0,\n" + "                    \"fieldType\": \"string\",\n"
            + "                    \"dateFormat\": null\n" + "                },\n" + "                {\n"
            + "                    \"fieldName\": \"order_no\",\n" + "                    \"fieldAlias\": \"商城订单号\",\n"
            + "                    \"fieldIsNested\": 0,\n" + "                    \"fieldIsArray\": 1,\n"
            + "                    \"fieldIsAnalyzed\": 0,\n" + "                    \"fieldType\": \"string\",\n"
            + "                    \"dateFormat\": null\n" + "                },\n" + "                {\n"
            + "                    \"fieldName\": \"order_sub_no\",\n" + "                    \"fieldAlias\": \"商城子单号\",\n"
            + "                    \"fieldIsNested\": 1,\n" + "                    \"fieldIsArray\": 0,\n"
            + "                    \"fieldIsAnalyzed\": 0,\n" + "                    \"fieldType\": \"string\",\n"
            + "                    \"dateFormat\": null\n" + "                },\n" + "                {\n"
            + "                    \"fieldName\": \"order_current_status\",\n" + "                    \"fieldAlias\": \"订单状态\",\n"
            + "                    \"fieldIsNested\": 0,\n" + "                    \"fieldIsArray\": 0,\n"
            + "                    \"fieldIsAnalyzed\": 1,\n" + "                    \"fieldType\": \"string\",\n"
            + "                    \"dateFormat\": null\n" + "                },\n" + "                {\n"
            + "                    \"fieldName\": \"order_current_platform\",\n" + "                    \"fieldAlias\": \"订单平台\",\n"
            + "                    \"fieldIsNested\": 0,\n" + "                    \"fieldIsArray\": 0,\n"
            + "                    \"fieldIsAnalyzed\": 0,\n" + "                    \"fieldType\": \"string\",\n"
            + "                    \"dateFormat\": null\n" + "                },\n" + "                {\n"
            + "                    \"fieldName\": \"order_last_update_time\",\n" + "                    \"fieldAlias\": \"订单状态时间\",\n"
            + "                    \"fieldIsNested\": 0,\n" + "                    \"fieldIsArray\": 0,\n"
            + "                    \"fieldIsAnalyzed\": 0,\n" + "                    \"fieldType\": \"date\",\n"
            + "                    \"dateFormat\": \"yyyy-MM-dd HH:mm:ss\"\n" + "                },\n" + "                {\n"
            + "                    \"fieldName\": \"delivery_store_id\",\n" + "                    \"fieldAlias\": \"发货店铺ID\",\n"
            + "                    \"fieldIsNested\": 0,\n" + "                    \"fieldIsArray\": 0,\n"
            + "                    \"fieldIsAnalyzed\": 0,\n" + "                    \"fieldType\": \"string\",\n"
            + "                    \"dateFormat\": null\n" + "                },\n" + "                {\n"
            + "                    \"fieldName\": \"delivery_store_desc\",\n" + "                    \"fieldAlias\": \"发货店铺名称\",\n"
            + "                    \"fieldIsNested\": 0,\n" + "                    \"fieldIsArray\": 0,\n"
            + "                    \"fieldIsAnalyzed\": 0,\n" + "                    \"fieldType\": \"string\",\n"
            + "                    \"dateFormat\": null\n" + "                },\n" + "                {\n"
            + "                    \"fieldName\": \"order_channel\",\n" + "                    \"fieldAlias\": \"下单渠道\",\n"
            + "                    \"fieldIsNested\": 0,\n" + "                    \"fieldIsArray\": 0,\n"
            + "                    \"fieldIsAnalyzed\": 0,\n" + "                    \"fieldType\": \"string\",\n"
            + "                    \"dateFormat\": null\n" + "                },\n" + "                {\n"
            + "                    \"fieldName\": \"order_date\",\n" + "                    \"fieldAlias\": \"订单日期\",\n"
            + "                    \"fieldIsNested\": 0,\n" + "                    \"fieldIsArray\": 0,\n"
            + "                    \"fieldIsAnalyzed\": 0,\n" + "                    \"fieldType\": \"date\",\n"
            + "                    \"dateFormat\": \"yyyy-MM-dd\"\n" + "                },\n" + "                {\n"
            + "                    \"fieldName\": \"order_time\",\n" + "                    \"fieldAlias\": \"订单时间\",\n"
            + "                    \"fieldIsNested\": 0,\n" + "                    \"fieldIsArray\": 0,\n"
            + "                    \"fieldIsAnalyzed\": 0,\n" + "                    \"fieldType\": \"date\",\n"
            + "                    \"dateFormat\": \"yyyy-MM-dd HH:mm:ss\"\n" + "                },\n" + "                {\n"
            + "                    \"fieldName\": \"order_qty\",\n" + "                    \"fieldAlias\": \"订单商品数量\",\n"
            + "                    \"fieldIsNested\": 0,\n" + "                    \"fieldIsArray\": 0,\n"
            + "                    \"fieldIsAnalyzed\": 0,\n" + "                    \"fieldType\": \"integer\",\n"
            + "                    \"dateFormat\": null\n" + "                },\n" + "                {\n"
            + "                    \"fieldName\": \"order_amt\",\n" + "                    \"fieldAlias\": \"订单金额\",\n"
            + "                    \"fieldIsNested\": 0,\n" + "                    \"fieldIsArray\": 0,\n"
            + "                    \"fieldIsAnalyzed\": 0,\n" + "                    \"fieldType\": \"double\",\n"
            + "                    \"dateFormat\": null\n" + "                },\n" + "                {\n"
            + "                    \"fieldName\": \"express_no\",\n" + "                    \"fieldAlias\": \"快递单号\",\n"
            + "                    \"fieldIsNested\": 0,\n" + "                    \"fieldIsArray\": 0,\n"
            + "                    \"fieldIsAnalyzed\": 0,\n" + "                    \"fieldType\": \"string\",\n"
            + "                    \"dateFormat\": null\n" + "                },\n" + "                {\n"
            + "                    \"fieldName\": \"ship_name\",\n" + "                    \"fieldAlias\": \"收货人\",\n"
            + "                    \"fieldIsNested\": 0,\n" + "                    \"fieldIsArray\": 0,\n"
            + "                    \"fieldIsAnalyzed\": 0,\n" + "                    \"fieldType\": \"string\",\n"
            + "                    \"dateFormat\": null\n" + "                },\n" + "                {\n"
            + "                    \"fieldName\": \"ship_mobile\",\n" + "                    \"fieldAlias\": \"收货人电话\",\n"
            + "                    \"fieldIsNested\": 0,\n" + "                    \"fieldIsArray\": 0,\n"
            + "                    \"fieldIsAnalyzed\": 0,\n" + "                    \"fieldType\": \"string\",\n"
            + "                    \"dateFormat\": null\n" + "                },\n" + "                {\n"
            + "                    \"fieldName\": \"crm_no\",\n" + "                    \"fieldAlias\": \"会员卡号\",\n"
            + "                    \"fieldIsNested\": 0,\n" + "                    \"fieldIsArray\": 0,\n"
            + "                    \"fieldIsAnalyzed\": 0,\n" + "                    \"fieldType\": \"string\",\n"
            + "                    \"dateFormat\": null\n" + "                },\n" + "                {\n"
            + "                    \"fieldName\": \"express_name\",\n" + "                    \"fieldAlias\": \"配送方\",\n"
            + "                    \"fieldIsNested\": 0,\n" + "                    \"fieldIsArray\": 0,\n"
            + "                    \"fieldIsAnalyzed\": 0,\n" + "                    \"fieldType\": \"string\",\n"
            + "                    \"dateFormat\": null\n" + "                },\n" + "                {\n"
            + "                    \"fieldName\": \"express_type\",\n" + "                    \"fieldAlias\": \"配送方式\",\n"
            + "                    \"fieldIsNested\": 0,\n" + "                    \"fieldIsArray\": 0,\n"
            + "                    \"fieldIsAnalyzed\": 0,\n" + "                    \"fieldType\": \"string\",\n"
            + "                    \"dateFormat\": null\n" + "                },\n" + "                {\n"
            + "                    \"fieldName\": \"replace_flag\",\n" + "                    \"fieldAlias\": \"是否换货Y/N\",\n"
            + "                    \"fieldIsNested\": 0,\n" + "                    \"fieldIsArray\": 0,\n"
            + "                    \"fieldIsAnalyzed\": 0,\n" + "                    \"fieldType\": \"string\",\n"
            + "                    \"dateFormat\": null\n" + "                },\n" + "                {\n"
            + "                    \"fieldName\": \"return_flag\",\n" + "                    \"fieldAlias\": \"是否退货Y/N\",\n"
            + "                    \"fieldIsNested\": 0,\n" + "                    \"fieldIsArray\": 0,\n"
            + "                    \"fieldIsAnalyzed\": 0,\n" + "                    \"fieldType\": \"string\",\n"
            + "                    \"dateFormat\": null\n" + "                }\n" + "            ],\n" + "            \"dimensions\": {\n"
            + "                \"headers\": [\n" + "                    \"id\",\n" + "                    \"order_no\",\n"
            + "                    \"order_sub_no\",\n" + "                    \"order_current_status\",\n"
            + "                    \"order_current_platform\",\n" + "                    \"order_last_update_time\",\n"
            + "                    \"delivery_store_id\",\n" + "                    \"delivery_store_desc\",\n"
            + "                    \"order_channel\",\n" + "                    \"order_date\",\n" + "                    \"order_time\",\n"
            + "                    \"order_qty\",\n" + "                    \"order_amt\",\n" + "                    \"express_no\",\n"
            + "                    \"ship_name\",\n" + "                    \"ship_mobile\",\n" + "                    \"crm_no\",\n"
            + "                    \"express_name\",\n" + "                    \"express_type\",\n" + "                    \"replace_flag\",\n"
            + "                    \"return_flag\"\n" + "                ]\n" + "            }\n" + "        },\n" + "        \"dataset\": {\n"
            + "            \"total\": 1000,\n" + "            \"pageSize\": 100,\n" + "            \"currentPage\": 1,\n"
            + "            \"sort\": null,\n" + "            \"order\": null,\n" + "            \"list\": [\n" + "                {\n"
            + "                    \"id\": \"817b9c38145e4022b8d8839d7e3a5214\",\n" + "                    \"order_no\": \"2021380073000032\",\n"
            + "                    \"order_sub_no\": null,\n" + "                    \"order_current_status\": \"HAVESIGN\",\n"
            + "                    \"order_current_platform\": \"KMS\",\n"
            + "                    \"order_last_update_time\": \"2020-09-04 11:22:44\",\n" + "                    \"delivery_store_id\": \"3342\",\n"
            + "                    \"delivery_store_desc\": \"SZ深圳凤凰中心\",\n" + "                    \"order_channel\": \"JDDJ_MZ\",\n"
            + "                    \"order_date\": \"2020-09-04 00:00:00\",\n" + "                    \"order_time\": \"2020-09-04 10:54:32\",\n"
            + "                    \"order_qty\": 6,\n" + "                    \"order_amt\": 162.1,\n"
            + "                    \"express_no\": \"2021380073000032\",\n" + "                    \"ship_name\": \"戴\",\n"
            + "                    \"ship_mobile\": \"13049802586,5449\",\n" + "                    \"crm_no\": null,\n"
            + "                    \"express_name\": \"dada\",\n" + "                    \"express_type\": \"CND\",\n"
            + "                    \"replace_flag\": null,\n" + "                    \"return_flag\": null\n" + "                }\n"
            + "            ]\n" + "        }\n" + "    }\n" + "}";
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private BaseResponse carNotFoundHandler(CarNotFoundException e) {
        return BaseResponses.notFound(e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    private BaseResponse unknownException(Exception e) {
        return BaseResponses.internalServerError(e.getMessage());
    }
}
