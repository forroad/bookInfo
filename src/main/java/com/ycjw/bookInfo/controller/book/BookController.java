package com.ycjw.bookInfo.controller.book;

import com.ycjw.bookInfo.exception.ExceptionZyc;
import com.ycjw.bookInfo.model.response.Response;
import com.ycjw.bookInfo.service.book.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("book")
public class BookController {
    @Autowired
    BookService bookServices;

    @ApiOperation("添加书籍")
    @PutMapping("add")
    public Response addBook(@RequestParam("name") String name,
                            @RequestParam("author") String author,
                            @RequestParam("shortInfo") String shortInfo) throws ExceptionZyc{
        return new Response("添加成功",bookServices.addBook(name, author, shortInfo));
    }

    @ApiOperation("删除书籍")
    @DeleteMapping("delete")
    public Response deleteBook(@RequestParam("id")  String id) throws ExceptionZyc{
        return new Response("删除成功",bookServices.deleteBook(id));
    }

    @ApiOperation("通过书名或作者模糊查询书籍")
    @GetMapping("find")
    public Response findBook(@RequestParam(value = "name",required = false) String name,
                             @RequestParam(value = "author",required = false) String author) throws ExceptionZyc{
        return new Response("查询成功", bookServices.findBook(name, author));
    }

    @ApiOperation("更新书名")
    @PostMapping("updateName")
    public Response updateBookName(@RequestParam("id") String id,
                                   @RequestParam("newName") String newName) throws ExceptionZyc{
        return new Response("更新成功",bookServices.updateBookName(id, newName));
    }

    @ApiOperation("更新作者")
    @PostMapping("updateAuthor")
    public Response updateBookAuthor(@RequestParam("id") String id,
                                     @RequestParam("newAuthor")String newAuthor) throws ExceptionZyc{
        return new Response("更新成功",bookServices.updateBookAuthor(id, newAuthor));
    }

    @ApiOperation("更新简介")
    @PostMapping("updateShortInfo")
    public Response updateBookShortInfo(@RequestParam("id") String id,
                                        @RequestParam("newShortInfo") String newShortInfo) throws ExceptionZyc{
        return new Response("更新成功", bookServices.updateBookShortInfo(id, newShortInfo));
    }
}
