Conclusion
0. ServletContext creating one per deployed application, if
1. Servlet instance creating after first servlet call
2. Only one srrvlet instance will created in Servlet container
3. method service(ServletRequest, ServletRespons) runs in new thread from thread pul per request
4. filters runs in the same thread as called servlet