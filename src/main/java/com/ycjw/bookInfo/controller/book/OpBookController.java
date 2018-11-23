package com.ycjw.bookInfo.controller.book;

import com.ycjw.bookInfo.exception.ExceptionZyc;
import com.ycjw.bookInfo.model.response.Response;
import com.ycjw.bookInfo.service.book.OpBookService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("opBook")
public class OpBookController {
    @Autowired
    OpBookService opBookService;

    @ApiOperation("借书")
    @PostMapping("borrow")
    public Response borrowBook(@RequestParam("userId") String userId,
                               @RequestParam("bookId") String bookId) throws ExceptionZyc{
        return new Response("借书成功", opBookService.borrowBook(userId, bookId));
    }

    @ApiOperation("还书")
    @PostMapping("return")
    public Response returnBook(@RequestParam("borrowRecordId") String borrowRecordId) throws ExceptionZyc{
        return new Response("还书成功",opBookService.returnBook(borrowRecordId));
    }

    @ApiOperation("赔付")
    @PostMapping("pay")
    public Response payBookMoney(@RequestParam("borrowRecordId") String borrowRecordId,
                                 @RequestParam("payMoney")double payMoney) throws ExceptionZyc{
        return new Response("赔付成功",opBookService.payBookMoney(borrowRecordId,payMoney));
    }

    @ApiOperation("查询未处理的借阅列表")
    @GetMapping("findAllBorrowBooks")
    public Response getAllBorrowBooks(@RequestParam("userId") String userId) throws ExceptionZyc{
        return new Response("查询成功",opBookService.getAllBorrowBooks(userId));
    }
}
