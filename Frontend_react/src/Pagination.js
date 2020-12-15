import React from "react";

const Pagination = ( {restPerPage,total,paginate})=>{
    const pageNumbers=[];

    for(let i=1;i<=Math.ceil(total / restPerPage);i++){
        pageNumbers.push(i);
    }

    return(
      <nav aria-label="Page navigation example align-center">
          <ul className="pagination">
          <li class="page-item disabled">
            <a class="page-link" href="#" tabindex="-1">Older</a>
         </li>
            {pageNumbers.map(number=>(
                <li key={number} className="page-item">
                    <a onClick={()=>paginate(number)} href="!#" className="page-link">
                        {number}
                    </a>
                </li>
            ))}
            <li class="page-item">
            <a class="page-link" href="#">Newer</a>
            </li>
          </ul>
      </nav>
    )
}

export default Pagination