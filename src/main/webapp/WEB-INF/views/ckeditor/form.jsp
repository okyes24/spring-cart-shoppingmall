<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/include/top.jsp"/>
 <style>
            #container {
                width: 1000px;
                margin: 20px auto;
            }
            .ck-editor__editable[role="textbox"] {
                /* Editing area */
                min-height: 200px;
            }
            .ck-content .image {
                /* Block images */
                max-width: 80%;
                margin: 20px auto;
            }
        </style>

<section>
<br>
<div align="center" >
<h2> 위지윅 게시판 글쓰기   </h2>
<form method="post"  action="${path}/ckeditor/insert.do" enctype="multipart/form-data">
<table border=1 width=500>
<tr> <td width=70  align="center" >제목 </td> <td> <input type=text  name=title  size=40> </td> </tr>
<tr> <td  align="center">이름 </td> <td> <input type=text  name=name></td> </tr>
<tr> <td  align="center">내용 </td> <td> 
  <textarea cols=50 rows=6 id="editor" name=etc></textarea>
 </td> </tr>
 <tr> <td  align="center">파일첨부 </td> 
 <td> <input type=file  name=uploadFile></td> </tr>
<tr> <td colspan=2 align="center">
 <input  type=submit value="저장하기" >
 </td> </tr>
</table>
</form>
</div>
<br>

 <script src="https://cdn.ckeditor.com/ckeditor5/41.3.1/super-build/ckeditor.js"></script>

        <script>
            CKEDITOR.ClassicEditor.create(document.getElementById("editor"), {

                toolbar: {
                    items: [
                        'exportPDF','exportWord', '|',
                        'findAndReplace', 'selectAll', '|',
                        'heading', '|',
                        'bold', 'italic', 'strikethrough', 'underline', 'code', 'removeFormat', '|',
                        'bulletedList', 'numberedList', 'todoList', '|',
                        'outdent', 'indent', '|',
                        'undo', 'redo',
                        '-',
                        'fontSize', 'fontFamily', 'fontColor', 'fontBackgroundColor', 'highlight', '|',
                        'alignment', '|',
                        'link', 'uploadImage', 'blockQuote', 'insertTable', 'mediaEmbed', 'codeBlock', 'htmlEmbed', '|',
                        'specialCharacters', 'horizontalLine', 'pageBreak', '|',
                        'textPartLanguage', '|',
                        'sourceEditing'
                    ],
                    shouldNotGroupWhenFull: true
                },

                list: {
                    properties: {
                        styles: true,
                        startIndex: true,
                        reversed: true
                    }
                },

                heading: {
                    options: [
                        { model: 'paragraph', title: 'Paragraph', class: 'ck-heading_paragraph' },
                        { model: 'heading1', view: 'h1', title: 'Heading 1', class: 'ck-heading_heading1' },
                        { model: 'heading2', view: 'h2', title: 'Heading 2', class: 'ck-heading_heading2' },
                        { model: 'heading3', view: 'h3', title: 'Heading 3', class: 'ck-heading_heading3' },
                        { model: 'heading4', view: 'h4', title: 'Heading 4', class: 'ck-heading_heading4' },
                    ]
                },
                placeholder: 'Welcome to CKEditor 5!',
                fontFamily: {
                    options: [
                        'default',
                        'Arial, Helvetica, sans-serif',
                        'Courier New, Courier, monospace',
                        'Trebuchet MS, Helvetica, sans-serif',
                        'Verdana, Geneva, sans-serif'
                    ],
                    supportAllValues: true
                },
                fontSize: {
                    options: [ 10, 12, 14, 'default', 18, 20, 22 ],
                    supportAllValues: true
                },
                htmlSupport: {
                    allow: [
                        {
                            name: /.*/,
                            attributes: true,
                            classes: true,
                            styles: true
                        }
                    ]
                },
                htmlEmbed: {
                    showPreviews: true
                },
                 link: {
                    decorators: {
                        addTargetToExternalLinks: true,
                        defaultProtocol: 'https://',
                        toggleDownloadable: {
                            mode: 'manual',
                            label: 'Downloadable',
                            attributes: {
                                download: 'file'
                            }
                        }
                    }
                },
                mention: {
                    feeds: [
                        {
                            marker: '@',
                            feed: [
                                '@apple', '@bears', '@brownie', '@cake', '@cake', '@candy', '@canes', '@chocolate',
                                '@sugar', '@sweet', '@topping', '@wafer'
                            ],
                            minimumCharacters: 1
                        }
                    ]
                },
                removePlugins: [
                    'AIAssistant',  'CKBox',   'CKFinder',    'EasyImage',   'MultiLevelList',
                    'RealTimeCollaborativeComments',   'RealTimeCollaborativeTrackChanges',
                    'RealTimeCollaborativeRevisionHistory',      'PresenceList',
                    'Comments',    'TrackChanges',    'TrackChangesData',  'RevisionHistory',
                    'Pagination',  'WProofreader',   'MathType',   'SlashCommand',
                    'Template',    'DocumentOutline', 'FormatPainter', 'TableOfContents',
                    'PasteFromOfficeEnhanced', 'CaseChange'
                ]
            });
        </script>


</section>
<c:import url="/include/bottom.jsp"/>