using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using Herlivre_api.Models;
using herlivre_api.Models;

namespace Herlivre_api.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class RegistroAluguelQuartoController : ControllerBase
    {
        private readonly GeralDbContext _context;

        public RegistroAluguelQuartoController(GeralDbContext context)
        {
            _context = context;
        }

        // GET: api/RegistroAluguelQuarto
        [HttpGet]
        public async Task<ActionResult<IEnumerable<RegistroAluguelQuarto>>> GetRegistroAluguelQuartos()
        {
            return await _context.RegistroAluguelQuartos.ToListAsync();
        }

        // GET: api/RegistroAluguelQuarto/5
        [HttpGet("{id}")]
        public async Task<ActionResult<RegistroAluguelQuarto>> GetRegistroAluguelQuarto(long id)
        {
            var registroAluguelQuarto = await _context.RegistroAluguelQuartos.FindAsync(id);

            if (registroAluguelQuarto == null)
            {
                return NotFound();
            }

            return registroAluguelQuarto;
        }

        // PUT: api/RegistroAluguelQuarto/5
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPut("{id}")]
        public async Task<IActionResult> PutRegistroAluguelQuarto(long id, RegistroAluguelQuarto registroAluguelQuarto)
        {
            if (id != registroAluguelQuarto.Id)
            {
                return BadRequest();
            }

            _context.Entry(registroAluguelQuarto).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!RegistroAluguelQuartoExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return NoContent();
        }

        // POST: api/RegistroAluguelQuarto
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPost]
        public async Task<ActionResult<RegistroAluguelQuarto>> PostRegistroAluguelQuarto(RegistroAluguelQuarto registroAluguelQuarto)
        {
            _context.RegistroAluguelQuartos.Add(registroAluguelQuarto);
            await _context.SaveChangesAsync();

            return CreatedAtAction("GetRegistroAluguelQuarto", new { id = registroAluguelQuarto.Id }, registroAluguelQuarto);
        }

        // DELETE: api/RegistroAluguelQuarto/5
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteRegistroAluguelQuarto(long id)
        {
            var registroAluguelQuarto = await _context.RegistroAluguelQuartos.FindAsync(id);
            if (registroAluguelQuarto == null)
            {
                return NotFound();
            }

            _context.RegistroAluguelQuartos.Remove(registroAluguelQuarto);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        private bool RegistroAluguelQuartoExists(long id)
        {
            return _context.RegistroAluguelQuartos.Any(e => e.Id == id);
        }
    }
}
